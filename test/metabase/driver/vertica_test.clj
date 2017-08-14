(ns metabase.driver.vertica-test
  (:require [expectations :refer :all]
            [metabase.test
             [util :as tu]]
            [metabase.test.data.datasets :refer [expect-with-engine]])
  (:import [metabase.driver.vertica VerticaDriver]))

(expect-with-engine :vertica
  "UTC"
  (tu/db-timezone-id))
