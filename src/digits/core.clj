(ns digits.core
  (:require [digits.data :as data]
            [digits.classify :as classify])
  (:import [digits Dashboard RandomGuesser DigitGuesser]))

(defn count-transitions [image]
  (loop [n 0 ink? false data image]
    (if (empty? data)
      n
      (if (> (first data) 0)
        (if ink?
          (recur n true (rest data))
          (recur (inc n) true (rest data)))
        (recur n false (rest data))))))

(defn ink-weight [weights] (apply + weights))

(defn -main []
  (let [_ (println "Loading training data...")
        training-duo (data/serialized-training-data)
        training (into-array (map second training-duo))
        answers (into-array Short/TYPE (map first training-duo))

        _ (println "Loading test data...")
        testing (into-array (data/serialized-test-data))

        _ (println "Training the classifier...")
        strategy (classify/create-classification-strategy {:ink-weight ink-weight :transition-count count-transitions}
                                                          [:lazy :ibk {:num-neighbors 5}]
                                                          training-duo)

        table {:0 0 :1 1 :2 2 :3 3 :4 4 :5 5 :6 6 :7 7 :8 8 :9 9}
        guesser (reify DigitGuesser (guess [_ d] (get table (classify/classify strategy d))))
        dashboard (Dashboard. training answers testing guesser)]
    (.showDashboard dashboard)))

