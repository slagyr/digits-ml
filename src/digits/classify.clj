(ns digits.classify
  (:require [clj-ml.classifiers :as ml]
            [clj-ml.data :as data]
            [digits.trait :refer [yield-essence]]))

(deftype ClassificationStrategy [traits ds classifier])

(defn traits [s] (.traits s))

;(defn exhibit-traits
;  ([traits data class] (vec (concat [class] (mapv #((second %) data) traits))))
;  ([traits data] (exhibit-traits traits data nil)))

(defn- create-dataset [traits data]
  (-> (data/make-dataset "digit"
                         (concat [{:class [:0 :1 :2 :3 :4 :5 :6 :7 :8 :9]}] (map :key traits))
                         (map #(yield-essence traits (second %) (first %)) data))
      (data/dataset-set-class 0)))

(defn create-classification-strategy [traits classification-options data]
  (let [ds (create-dataset traits data)
        classifier (apply ml/make-classifier classification-options)]
    (ClassificationStrategy. (seq traits)
                             ds
                             (ml/classifier-train classifier ds))))


(defn ds [s] (.ds s))

(defn classifier [s] (.classifier s))

(defn classify [s data]
  (let [instance (data/make-instance (.ds s) (yield-essence (.traits s) data))]
    (ml/classifier-classify (.classifier s) instance)))

(defn cross-validate [s folds]
  (ml/classifier-evaluate (.classifier s) :cross-validation (.ds s) folds))


