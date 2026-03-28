CREATE TABLE IF NOT EXISTS public.turn
(
    id               UUID PRIMARY KEY,
    appointment_date TIMESTAMP,
    status           VARCHAR(20),
    customer_name    VARCHAR(100),
    service_id       UUID REFERENCES public.barber_service(id),
    created_at       TIMESTAMP,
    updated_at       TIMESTAMP
);
