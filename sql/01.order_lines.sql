create table if not exists public.order_lines
(
    id            bigserial
    constraint order_lines_pk
    primary key,
    order_id      bigint,
    customer_id   text,
    customer_name text,
    product_id    bigint,
    product_name  text,
    quantity      integer,
    total_price   double precision,
    date          date,
    follow_up     boolean default false
);