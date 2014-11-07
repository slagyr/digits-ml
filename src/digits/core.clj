(ns digits.core
  (:require [digits.data :as data])
  (:import [digits Dashboard]))

(defn- load-training-data []
  (println "loading training data...")
  (let [data (data/training-data)]
    [(into-array Short/TYPE (map first data))
     (into-array (map second data))]))

(defn- load-testing-data []
  (println "loading testing data...")
  (let [data (data/test-data)]
    (into-array data)))

(defn -main []
  (let [[answers training] (load-training-data)
        testing (load-testing-data)
        dashboard (Dashboard. training answers testing)]
    (.showDashboard dashboard)))
