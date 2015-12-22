(ns task-3.core)

(defrecord GridValue [pos value])

(def base (GridValue. 0 0))

(defn stepOfIntegration
  [func position step]
  (*
    (/
      (+
        (func (+ step position))
        (func position) )
      2)
    step))

(defn inSeq [f, h]
  (lazy-seq (cons base (map (fn [a]
                              (let [b (assoc a :value (+ (integrationStep f (:pos a) h) (:value a)))]
                                (assoc b :pos (+ h (:pos b))))
                              )
                            (inSeq f h)))))

(defn quadraticFunc
  "test quadratic function"
  [x]
  (* x x)
  )

(defn createIntegrale [f, h]
  (let [seq (inSeq f h) ]
    (fn [a]
      (let [last (mod a h)]
        (+ (stepOfIntegration f (- a last) last) (:value (nth seq (int (quot a h))))))
      )
    )
  )


(defn integrate  [func step]
  (:pre [(> x 0)])
  (let [seq (inSeq func step)]
    (fn [x]
      (let [last (mod x step)]
        (+ (stepOfIntegration func (- x last) last) (:value (nth seq (int (quot x step)))))
      )
    )
  )
)

(def qF (createIntegral quadraticFunc 1/10))