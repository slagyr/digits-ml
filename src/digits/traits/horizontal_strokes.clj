(ns digits.traits.horizontal-strokes
  (:require [digits.traits.vertical-strokes :as vertical]))

(def min-horizontal 10)

(defn rotate-rows [personality]
  (let [rows (:rows personality)]
    (mapv
      (fn [n]
        (mapv #(nth % n) rows))
      (range 28))))

(def columns {:key      :columns
              :fn       rotate-rows
              :requires [vertical/rows]})

(defn count-horizontal-strokes [personality]
  (let [cross-sections (map vertical/cross-section (:columns personality))
        segments (vertical/vertical-segments cross-sections)]
    ;(println "segments: " segments)
    ;(println "(map count segments): " (map count segments))
    (count (filter #(<= min-horizontal (count %)) segments))
    ))

(def horizontal-strokes {:key      :horizontal-strokes
                         :fn       count-horizontal-strokes
                         :requires [columns]})