create table if not exists public.orders
(
    id             bigserial
    constraint orders_pk
    primary key,
    "orderId"      bigint,
    "customerId"   text,
    "customerName" text,
    "productId"    bigint,
    "productName"  text,
    quantity       integer,
    "totalPrice"   double precision,
    date           date
)