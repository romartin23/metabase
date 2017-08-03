(ns metabase.sync.sync-metadata.sync-timezone
  (:require [schema.core :as s]
            [metabase.sync
             [interface :as i]]
            [metabase.driver :as driver]
            [toucan.db :as db]
            [metabase.models.database :refer [Database]])
  (:import [org.joda.time DateTime]))


(defn- extract-time-zone [^DateTime dt]
  (-> dt .getChronology .getZone .getID))

(s/defn sync-timezone!
  "Query `DATABASE` for it's current time to determine it's
  timezone. Update that timezone if it's different."
  [database :- i/DatabaseInstance]
  (let [tz-id (some-> database
                      driver/->driver
                      (driver/current-db-time database)
                      extract-time-zone)]
    (when-not (= tz-id (:timezone database))
      (db/update! Database (:id database) {:timezone tz-id}))))
