-- Arquivo exercicio_somador.vhdl
-- Modelo exercicio somador completo
library IEEE;
use IEEE.std_logic_1164.all;

entity exercicio_somador is
  port (
    a : in bit;
    b : in bit;
    te : in bit;
    s : out bit;
    ts : out bit
  );
end exercicio_somador;
  
architecture arquitetura_somador of exercicio_somador is
begin
  s <= (a xor b) xor te;
  ts <= (b and te) or (a and te) or (a and b);
end arquitetura_somador;
