-- Arquivo exercicio_4.vhdl
-- Modelo exercicio 4
library IEEE;
use IEEE.std_logic_1164.all;

entity exercicio_4 is
  port (
    a : in bit;
    b : in bit;
    c : in bit;
    d : in bit;
    z : out bit
  );
end exercicio_4;
  
architecture arquitetura_4 of exercicio_4 is
begin
  z <= ((a and b) or (b and c) and d);
end arquitetura_4;
