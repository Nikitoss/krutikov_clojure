(ns task-3.test
  (:require [clojure.test :as test])
  (:use     task-3.core))

(defn quadAnIntegr [x] (double (* x x x 1/3)))
(defn quad [x] (double (* x x)))

(test/deftest step-test
  (test/testing "comparison with analytic integral of x^2, accyracy 2%, value 0"
    (test/is (<= (integrate quad 0.01 0) (*(quadAnIntegr 0) 1.02)))
    (test/is (>= (integrate quad 0.01 0) (*(quadAnIntegr 0) 0.98))))
  (test/testing "comparison with analytic integral of x^2, accyracy 2%, value 1"
    (test/is (<= (integrate quad 0.01 1) (*(quadAnIntegr 1) 1.02)))
    (test/is (>= (integrate quad 0.01 1) (*(quadAnIntegr 1) 0.98))))
  (test/testing "comparison with analytic integral of x^2, accyracy 2%, value 10"
    (test/is (<= (integrate quad 0.01 10) (*(quadAnIntegr 10) 1.02)))
    (test/is (>= (integrate quad 0.01 10) (*(quadAnIntegr 10) 0.98)))))

(test/run-tests)