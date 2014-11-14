(ns digits.trait-spec
  (:require [digits.classify :as classify]
            [digits.trait :refer :all]
            [digits.data :as data]
            [digits.samples :refer [samples]]
            [speclj.core :refer :all]))

(def sum {:key :sum :fn #(apply + (:data %))})
(def size {:key :size :fn #(count (:data %))})

(describe "Traits"

  (it "exhibits a trait"
    (should= {:data [1 2 3] :sum 6}
             (exhibit-trait sum {:data [1 2 3]}))
    (should= {:data [1 2 3] :size 3}
             (exhibit-trait size {:data [1 2 3]})))

  (it "exhibits dependent traits"
    (should= {:data [1 2 3] :sum 6 :size 3}
             (exhibit-trait (assoc sum :requires [size]) {:data [1 2 3]}))
    (should= {:data [1 2 3] :sum 6 :size 3}
             (exhibit-trait (assoc size :requires [sum]) {:data [1 2 3]})))

  (it "builds personality"
    (should= {:data [1 2 3] :sum 6}
             (build-personality [sum] [1 2 3]))
    (should= {:data [1 2 3] :size 3}
             (build-personality [size] [1 2 3]))
    (should= {:data [1 2 3] :sum 6 :size 3}
             (build-personality [sum size] [1 2 3]))
    (should= {:data [1 2 3] :sum 6 :size 3}
             (build-personality [(assoc size :requires [sum])] [1 2 3])))

  (it "yields essence"
    (should= [nil 6 3] (yield-essence [sum size] [1 2 3]))
    (should= [:foo 6 3] (yield-essence [sum size] [1 2 3] :foo))
    (should= [nil 3 6] (yield-essence [size sum] [1 2 3])))

  )


(run-specs)