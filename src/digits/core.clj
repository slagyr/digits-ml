(ns digits.core
  (:require [digits.data :as data])
  (:import [digits Dashboard]))

(defn- load-training-data []
  (println "loading training data...")
  (let [data (data/training-data)]
    (to-array-2d (map second data))))

(defn- load-testing-data []
  (println "loading testing data...")
  (let [data (data/test-data)]
    (to-array-2d data)))

(defn -main []
  (let [training (load-training-data)
        testing (load-testing-data)
        dashboard (Dashboard. training testing)]
    (println "opening dashboard...")
    (.showDashboard dashboard)))

(-main)