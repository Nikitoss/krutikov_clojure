(ns task-1.test
  (:require [clojure.test :as test])
  (:use     task-1.core))

(def test1 '((\a) (\b) (\c)))
(def test2 '((\a \b) (\a \c) (\b \a) (\b \c) (\c \a) (\c \b)))
(def test3 '((\a \b \a) (\a \b \c) (\a \c \a) (\a \c \b) (\b \a \b) (\b \a \c) (\b \c \a) (\b \c \b) (\c \a \b) (\c \a \c) (\c \b \a) (\c \b \c)))

(test/deftest task-1-test
  (test/testing "testing with len set to 1"
    (test/is (= (task1-foo "abc" 1) test1)))
  (test/testing "testing with len set to 2"
    (test/is (= (task1-foo "abc" 2) test2)))
  (test/testing "testing with len set to 3"
    (test/is (= (task1-foo "abc" 3) test3))))

(test/run-tests)