(ns digits.data-spec
  (:require [speclj.core :refer :all]
            [digits.data :refer :all]))

(describe "Data"

  (it "train data has 42000 values"
    (should= 42000 (count (training-data))))

  (it "test data has 28000 values"
    (should= 28000 (count (test-data))))

  (it "each training row has an answer and an image with 784 columns"
    (doseq [[answer image] (take 10 (training-data))]
      (should (<= 0 answer 9))
      (should= 784 (count image))))

  )

(run-specs)