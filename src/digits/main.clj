(ns digits.main
  (:require [digits.classify :as classify]
            [digits.data :as data]
            [digits.core :as core]
            [digits.traits.transition-count :refer [transition-count]])
  (:import [digits Dashboard RandomGuesser DigitGuesser]))

(defn -main []
  (let [_ (println "Loading training data...")
        training-duo (data/serialized-training-data)
        training (into-array (map second training-duo))
        answers (into-array Short/TYPE (map first training-duo))

        _ (println "Loading test data...")
        testing (into-array (data/serialized-test-data))

        _ (println "Training the classifier...")
        strategy (core/create-classifier training-duo)

        table {:0 0 :1 1 :2 2 :3 3 :4 4 :5 5 :6 6 :7 7 :8 8 :9 9}
        guesser (reify DigitGuesser (guess [_ d] (get table (classify/classify strategy d))))
        dashboard (Dashboard. training answers testing guesser)]
    (.showDashboard dashboard)))

