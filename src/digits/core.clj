(ns digits.core
  (:require [digits.data :as data]
            [digits.classify :as classify]
            ;[clj-ml.data :as ds]
            ;[clj-ml.classifiers :as classify]
            )
  (:import [digits Dashboard RandomGuesser DigitGuesser]))

(defn- load-training-data []
  (println "loading training data...")
  (let [data (data/serialized-training-data)]
    [
     (into-array (map second data))]))

(defn- load-testing-data []
  (println "loading testing data...")
  (let [data (data/serialized-test-data)]
    (into-array data)))

;(defn create-digit-dataset [data]
;  (-> (ds/make-dataset "digit"
;                       [{:class [:0 :1 :2 :3 :4 :5 :6 :7 :8 :9]}
;                        :ink-weight
;                        :transition-count]
;                       data)
;      (ds/dataset-set-class 0)))

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

;(defn ->instance [answer image] [(keyword (str answer)) (ink-weight image) (count-transitions image)])
;
;(defn ->instances [answers images] (map ->instance answers images))

;(defn classify [ds classifier image]
;  (let [instance (ds/instance-set-class-missing (ds/make-instance ds (->instance 1 image)))
;        answer-kw (classify/classifier-classify classifier instance)]
;    (Integer/parseInt (name answer-kw))))

(defn -main []
  (let [training-duo (data/serialized-training-data)
        training (into-array (map second training-duo))
        answers (into-array Short/TYPE (map first training-duo))
        testing (load-testing-data)

        strategy (classify/create-classification-strategy {:ink-weight ink-weight :transition-count count-transitions}
                                                       [:lazy :ibk {:num-neighbors 5}]
                                                       training-duo)
        ;ds (create-digit-dataset (->instances answers training))
        ;classifier (classify/make-classifier :lazy :ibk {:num-neighbors 5})
        ;_ (println "training...")
        ;trained (classify/classifier-train classifier ds)

        ;guesser (reify DigitGuesser (guess [_ d] (rand 10)))
        table {:0 0 :1 1 :2 2 :3 3 :4 4 :5 5 :6 6 :7 7 :8 8 :9 9}
        guesser (reify DigitGuesser (guess [_ d] (get table (classify/classify strategy d))))
        dashboard (Dashboard. training answers testing guesser)]
    (.showDashboard dashboard)))


;(let [strategy (create-classification-strategy {:size count}
;                                               [:lazy :ibk {:num-neighbors 5}]
;                                               data)]
;  (classify blah))
