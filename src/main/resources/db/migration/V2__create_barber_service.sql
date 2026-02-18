CREATE TABLE IF NOT EXISTS public.barber_service
(
    id UUID PRIMARY KEY,
    name VARCHAR(60) NOT NULL,
    description VARCHAR(100),
    price NUMERIC NOT NULL,
    time_on_minutes NUMERIC NOT NULL
);