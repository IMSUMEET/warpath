#!/usr/bin/env bash
# Compile all Java sources into out/ and run the app.
set -e
cd "$(dirname "$0")"
javac -d out $(find src -name "*.java")
java -cp out Warpath
