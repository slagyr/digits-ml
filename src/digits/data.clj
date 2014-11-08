(ns digits.data
  (:require [clojure.java.io :as io]))

(defn ->i [str] (Integer/parseInt str))

(defn lines [reader]
  (if-let [line (.readLine reader)]
    (cons line (lazy-seq (lines reader)))
    ()))

(defn csv-training-data []
  (let [lines (rest (lines (io/reader "data/train.csv")))
        rows (map #(.split % ",") lines)]
    (map
      (fn [[answer & image]] (list (->i answer) (into-array Short/TYPE (map ->i image))))
      rows)))

(defn serialized-training-data []
  (with-open [ois (java.io.ObjectInputStream. (java.io.FileInputStream. "data/train.ser"))]
    (.readObject ois)))

(defn csv-test-data []
  (let [lines (rest (lines (io/reader "data/test.csv")))
        rows (map #(.split % ",") lines)]
    (map
      #(into-array Short/TYPE (map ->i %))
      rows)))

(defn serialized-test-data []
  (with-open [ois (java.io.ObjectInputStream. (java.io.FileInputStream. "data/test.ser"))]
    (.readObject ois)))