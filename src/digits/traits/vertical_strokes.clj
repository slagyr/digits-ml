(ns digits.traits.vertical-strokes
  (:require [clojure.set :as set]))

(def min-ink (int (* 255 0.5)))
(def max-horizontal 6)
(def min-vertical 10)

(defn split-into-rows [personality]
  (partition 28 (:data personality)))

(def rows {:key :rows
           :fn  split-into-rows})

(defn cross-section [row]
  (loop [result [] spot nil col 0 row row]
    (if (empty? row)
      result
      (if (> (first row) min-ink)
        (if spot
          (recur result (conj spot col) (inc col) (rest row))
          (recur result [col] (inc col) (rest row)))
        (if spot
          (recur (conj result spot) nil (inc col) (rest row))
          (recur result nil (inc col) (rest row)))))))

(defn short-enough [spot]
  (<= (count spot) max-horizontal))

(defn extend-segment [[segment spot]]
  (if (short-enough spot)
    (conj segment spot)
    (conj segment (set/intersection (last segment) spot))))

(defn snap-segments [segments spots]
  (if-let [spots (seq spots)]
    (let [combos (for [segment segments spot spots] [segment spot])
          {overlapping true isolated false} (group-by (fn [[segment spot]] (not (empty? (set/intersection (last segment) spot)))) combos)
          terminated-segments (set/difference (set (map first isolated)) (set (map first overlapping)))
          new-spots (set/difference (set (map second isolated)) (set (map second overlapping)))]
      (concat
        (map extend-segment overlapping)
        (map #(conj % #{}) terminated-segments)
        (map vector (filter short-enough new-spots))))
    (map #(conj % #{}) segments)))

(defn vertical-segments [cross-sections]
  (loop [segments [] cross-sections cross-sections]
    (if (empty? cross-sections)
      (map #(filter seq %) segments)
      (let [spots (map set (first cross-sections))]
        (if (and (empty? segments) (seq spots))
          (recur (map vector (filter short-enough spots)) (rest cross-sections))
          (recur (snap-segments segments spots) (rest cross-sections))))
      )))

(defn count-vertical-strokes [personality]
  (let [cross-sections (map cross-section (:rows personality))
        segments (vertical-segments cross-sections)]
    ;(println "segments: " segments)
    ;(println "(map count segments): " (map count segments))
    (count (filter #(<= min-vertical (count %)) segments))
    ))

(def vertical-strokes {:key      :vertical-strokes
                       :fn       count-vertical-strokes
                       :requires [rows]})

