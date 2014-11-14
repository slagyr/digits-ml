(ns digits.classify-spec
  (:require [speclj.core :refer :all]
            [digits.classify :refer :all]
            [clj-ml.data :as data]))

(def sum {:key :sum :fn #(apply + (:data %))})
(def size {:key :size :fn #(count (:data %))})

(describe "classify"

  (with strategy (create-classification-strategy [sum size]
                                                 [:lazy :ibk {:num-neighbors 5}]
                                                 [[:1 [1 2 3]] [:2 [4]] [:3 [5 6]]]))

  (it "constructs a strategy"
    (should-not= nil @strategy)
    (should= sum (first (traits @strategy)))
    (should= size (second (traits @strategy))))

  (it "strategies have datasets"
    (let [ds (ds @strategy)]
      (should= "digit" (data/dataset-name ds))
      (should= :class (data/dataset-class-name ds))
      (should= #{:0 :1 :2 :3 :4 :5 :6 :7 :8 :9} (set (keys (data/dataset-class-labels ds))))
      (should= [:sum :size] (rest (data/dataset-format ds)))))

  (it "strategies have classifiers"
    (let [classifier (classifier @strategy)]
      (should= weka.classifiers.lazy.IBk (class classifier))
      (should= 3 (.getNumTraining classifier))))

  (it "identifies class of data"
    (should= :1 (classify @strategy [1 2 4])))

  (it "performs cross-validation"
    (let [result (cross-validate @strategy 2)]
      (should-contain :average-cost result)))

  (context "Data Model"



    ;(it "modeling 1 trait"
    ;  (should= {:data [1 2 3] :sum 6} (model-traits [[:sum (simple-trait :sum #(apply + %))]] [1 2 3])))

    )

  )
