-- V1__candidate_table.sql

CREATE TABLE tb_candidate (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  name VARCHAR(255),
  username VARCHAR(50) NOT NULL,
  email VARCHAR(255),
  password VARCHAR(64) NOT NULL CHECK (char_length(password) BETWEEN 8 AND 64),
  description TEXT,
  created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT now()
);
