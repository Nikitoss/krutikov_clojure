(ns task-3.test
  (:require [clojure.test :as test])
  (:use     task-3.core))

(defn quadAnIntegr [x] (double (* x x x 1/3)))
(defn quad [x] (double (* x x)))

(test/deftest step-test
  (test/testing "comparison with analytic integral of x^2, accyracy 2%, value 0"
    (test/is (<= (integrate quad 0.001 0) (*(quadAnIntegr 0) 1.01)))
    (test/is (>= (integrate quad 0.001 0) (*(quadAnIntegr 0) 0.99))))
  (test/testing "comparison with analytic integral of x^2, accyracy 2%, value 1"
    (test/is (<= (integrate quad 0.001 1) (*(quadAnIntegr 1) 1.01)))
    (test/is (>= (integrate quad 0.001 1) (*(quadAnIntegr 1) 0.99))))
  (test/testing "comparison with analytic integral of x^2, accyracy 2%, value 10"
    (test/is (<= (integrate quad 0.001 10) (*(quadAnIntegr 10) 1.01)))
    (test/is (>= (integrate quad 0.001 10) (*(quadAnIntegr 10) 0.99)))))

(test/run-tests)