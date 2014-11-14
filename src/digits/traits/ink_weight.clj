(ns digits.traits.ink-weight)

(defn weight-ink [weights] (apply + weights))
(def ink-weight {:key     :ink-weight
                  :fn      #(weight-ink (:data %))
                  :depends []})