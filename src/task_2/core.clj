(ns task-2.core)

(defn stepOfIntegration
  [func position step]
  (*
    (/
      (+
        (func (+ step position))
        (func position) )
      2)
    step))

(def memIntegrationStep (memoize (fn [func position step]
                                   (if (>= position 0)
                                     (do (print ".")
                                         (+ (stepOfIntegration func position step)
                                            (memIntegrationStep func (- position step) step)))
                                     0.0))))

(defn integrate
  [func step x]
  (:pre [(and (> step 0) (> x 0))])

  (let [last (mod x step)]
    (+ (stepOfIntegration func (- x last) last) (memIntegrationStep func (* step (- (int (quot x step)) 1)) step))
    )
  )