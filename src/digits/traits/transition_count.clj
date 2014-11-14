(ns digits.traits.transition-count)

(defn count-transitions [image]
  (loop [n 0 ink? false data image]
    (if (empty? data)
      n
      (if (> (first data) 0)
        (if ink?
          (recur n true (rest data))
          (recur (inc n) true (rest data)))
        (recur n false (rest data))))))

(def transition-count {:key     :transition-count
                        :fn      #(count-transitions (:data %))
                        :depends []})