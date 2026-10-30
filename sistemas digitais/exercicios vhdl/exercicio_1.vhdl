-- Arquivo exercicio_1.vhdl
-- Modelo exercicio 1
library IEEE;
use IEEE.std_logic_1164.all;

entity exercicio_1 is
  port (
    a : in bit;
    b : in bit;
    c : in bit;
    d : in bit;
    w : out bit
  );
end exercicio_1;
  
architecture arquitetura_1 of exercicio_1 is
begin
  w <= (a or b) and (c or d);
end arquitetura_1;
