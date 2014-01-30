(ns digits.data
  (:require [clojure.java.io :as io]))

(defn ->i [str] (Integer/parseInt str))

(defn lines [reader]
  (if-let [line (.readLine reader)]
    (cons line (lazy-seq (lines reader)))
    ()))

(defn training-data []
  (let [lines (rest (lines (io/reader "data/train.csv")))
        rows (map #(.split % ",") lines)]
    (map
      (fn [[answer & image]] (list (->i answer) (into-array Integer/TYPE (map ->i image))))
      rows)))

(defn test-data []
  (let [lines (rest (lines (io/reader "data/test.csv")))
        rows (map #(.split % ",") lines)]
    (map
      #(into-array Integer/TYPE (map ->i %))
      rows)))
