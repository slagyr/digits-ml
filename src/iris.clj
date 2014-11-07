(ns iris
  (require [clj-ml.io :as io]
           [clj-ml.data :as data]
           [clj-ml.classifiers :as classify]))


(def ds (-> (io/load-instances :arff "data/iris.arff")
            (data/dataset-set-class :class)))

(println ds)

(def dseq (data/dataset-seq ds))
(println (first dseq))

;(def classifier (classify/make-classifier :decision-tree :c45))
(def classifier (classify/make-classifier :lazy :ibk))

(def trained (classify/classifier-train classifier ds))

(prn "trained: " trained)

(def instance (-> (first (data/dataset-seq ds))
                  (data/instance-set-class-missing)))

(println (data/dataset-as-maps ds))

(println (classify/classifier-classify trained instance))
