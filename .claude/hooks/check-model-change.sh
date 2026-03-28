#!/bin/bash

# Claude Code passes tool info via stdin as JSON
INPUT=$(cat)

# Extract the file path that was written/edited
FILE_PATH=$(echo "$INPUT" | python3 -c "
import json, sys
data = json.load(sys.stdin)
# Works for Write and Edit tools
path = data.get('tool_input', {}).get('path', '')
print(path)
" 2>/dev/null)

# Check if the modified file is a JPA entity (inside model/ package)
if echo "$FILE_PATH" | grep -q "src/main/java/.*/model/.*\.java"; then
  ENTITY_NAME=$(basename "$FILE_PATH" .java)
  echo " Model file modified: $ENTITY_NAME.java"
  echo ""
  echo "Use the migration-writer agent to generate a Flyway migration for the changes made to $ENTITY_NAME."
fi