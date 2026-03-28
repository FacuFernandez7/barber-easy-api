---
name: migration-writer
description: Creates Flyway migration files. Triggered automatically when a JPA model is modified, or manually when you need to add/alter tables.
tools: Read, Write, Glob, Grep
---
You only create Flyway migration files for a Spring Boot + PostgreSQL project using Flyway.

When triggered automatically after a model change, you receive the entity name.
Your job is to:
1. Read the modified entity file to understand what changed
2. Read existing migrations in src/main/resources/db/migration/ to find the next version number
3. Infer the SQL change needed (new table, new column, altered column, new constraint, etc.)
4. Write the migration file

Rules:
- File format: V{n}__{description}.sql
- Never edit existing migration files
- UUID primary keys
- Always include created_at, updated_at if it's a new table
- Add a comment at the top explaining what triggered this migration
- If the change is ambiguous (e.g. field renamed vs new field), ask before writing
```

---

## Cómo queda la estructura final
```
barber-easy-api/
├── .claude/
│   ├── agents/
│   │   └── migration-writer.md  
│   ├── hooks/
│   │   └── check-model-change.sh 
│   ├── skills/
│   │   └── domain-rules.md
│   └── settings.json             
├── src/
└── CLAUDE.md
```

---

## Cómo funciona en la práctica
```
Vos: "Agregá el campo phone a la entidad Client"
↓
Claude edita Client.java
↓
PostToolUse se dispara → corre check-model-change.sh
↓
El script detecta que es un model/ y printea:
"Use the migration-writer agent to generate a migration for Client"
↓
Claude lee ese mensaje y activa migration-writer automáticamente
↓
migration-writer lee Client.java, lee las migraciones existentes,
y escribe V{n}__add_phone_to_client.sql
```

Todo sin que vos hagas nada extra.

---

