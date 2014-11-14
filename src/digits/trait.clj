(ns digits.trait)

(declare exhibit-trait)

(defn exhibit-traits [traits personality]
  (reduce #(exhibit-trait %2 %1) personality traits))

(defn exhibit-trait [trait personality]
  (let [personality (exhibit-traits (:requires trait) personality)
        result ((:fn trait) personality)]
    (assoc personality (:key trait) result)))

(defn build-personality [traits data]
  (exhibit-traits traits {:data data}))

(defn yield-essence
  ([traits data klass]
   (let [personality (build-personality traits data)]
     (vec (cons klass (map #(get personality (:key %)) traits)))))
  ([traits data] (yield-essence traits data nil)))