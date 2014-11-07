(ns digits.core
  (:require [digits.data :as data]
            [clj-ml.data :as ds]
            [clj-ml.classifiers :as classify])
  (:import [digits Dashboard RandomGuesser DigitGuesser]))

(defn- load-training-data []
  (println "loading training data...")
  (let [data (data/training-data)]
    [(into-array Short/TYPE (map first data))
     (into-array (map second data))]))

(defn- load-testing-data []
  (println "loading testing data...")
  (let [data (data/test-data)]
    (into-array data)))

(defn create-digit-dataset [data]
  (-> (ds/make-dataset "digit"
                       [{:class [:0 :1 :2 :3 :4 :5 :6 :7 :8 :9]}
                        :ink-weight]
                       data)
      (ds/dataset-set-class 0)))

(defn ink-weight [weights] (apply + weights))

(defn ->instance [answer image] [(keyword (str answer)) (ink-weight image)])

(defn ->instances [answers images] (map ->instance answers images))

(defn classify [ds classifier image]
  (let [instance (ds/instance-set-class-missing (ds/make-instance ds (->instance 1 image)))
        answer-kw (classify/classifier-classify classifier instance)]
    (Integer/parseInt (name answer-kw))))

(defn -main []
  (let [[answers training] (load-training-data)
        testing (load-testing-data)

        ds (create-digit-dataset (->instances answers training))
        classifier (classify/make-classifier :lazy :ibk)
        _ (println "training...")
        trained (classify/classifier-train classifier ds)

        ;guesser (reify DigitGuesser (guess [_ d] (rand 10)))
        guesser (reify DigitGuesser (guess [_ d] (classify ds trained d)))
        dashboard (Dashboard. training answers testing guesser)]
    (.showDashboard dashboard)))
