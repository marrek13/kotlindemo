CREATE TABLE domains (
	id text NOT NULL,
	shop_uuid text not null,
	merchant_code text not null,
	domain text not null,
	enabled bool NOT NULL,
	created_at timestamptz NOT NULL,
	updated_at timestamptz NOT NULL,
	CONSTRAINT domains_pkey PRIMARY KEY (id, merchant_code, shop_uuid)
);
