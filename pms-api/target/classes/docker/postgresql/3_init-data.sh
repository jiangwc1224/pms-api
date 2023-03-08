#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$PMS_DB_USER" --dbname "$PMS_DB_DATABASE" -f /docker-entrypoint-initdb.d/sql/data.sql