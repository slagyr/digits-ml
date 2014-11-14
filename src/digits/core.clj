(ns digits.core
  (:require [digits.classify :as classify]
            [digits.data :as data]
            [digits.traits.transition-count :refer [transition-count]]
            [digits.traits.vertical-strokes :refer [vertical-strokes]]
            [digits.traits.horizontal-strokes :refer [horizontal-strokes]]))

(defn create-classifier [training-data]
  (classify/create-classification-strategy [vertical-strokes horizontal-strokes]
                                           [:lazy :ibk {:num-neighbors 3}]
                                           training-data))