(ns task-1.core)

(defn task1-foo [symbol_set n]
  (:pre [(and (> n 0) (not (empty? symbol_set)))])
  (reduce
    (fn [res i]
      (for [x symbol_set
            y res
            :let [z (first y)]
            :when (not (= x z))]
        (cons x y)))
    (map (fn [i] (list i)) symbol_set)
    ( range 1 n)))