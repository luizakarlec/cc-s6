-- Arquivo exercicio_3.vhdl
-- Modelo exercicio 3
library IEEE;
use IEEE.std_logic_1164.all;

entity exercicio_3 is
  port (
    a : in bit;
    b : in bit;
    c : in bit;
    y : out bit
  );
end exercicio_3;
  
architecture arquitetura_3 of exercicio_3 is
begin
  y <= (((a and b) or b) and c);
end arquitetura_3;
