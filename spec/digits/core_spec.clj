(ns digits.core-spec
  (:require [speclj.core :refer :all]
            [digits.core :refer :all]
            [clj-ml.data :as data]))

(describe "digits.core"

          (it "creates a dataset"
              (let [data [[:1 100]]
                    ds (create-digit-dataset data)]

                (should= "digit" (data/dataset-name ds))
                (should= :class (data/dataset-class-name ds))
                (should= [{:class [:0 :1 :2 :3 :4 :5 :6 :7 :8 :9]} :ink-weight] (data/dataset-format ds))))

          (it "measures weight of large list"
              (should= 0 (ink-weight []))
              (should= 0 (ink-weight [0 0 0 0 0 0 0 0 0]))
              (should= 8 (ink-weight [1 1 1 1 1 1 1 1]))
              (should= (apply + (range 256)) (ink-weight (into-array Short/TYPE (range 256)))))


          (it "creates data instance from training data"
              (should= [:0 6] (->instance 0 [1 2 3])))

          (it "creates list of instances"
              (should= [[:0 3][:1 6][:2 9]]
                       (->instances [0 1 2] [[1 1 1][2 2 2][3 3 3]])))

          )