-- Arquivo componente_or.vhd
-- Modelo exercicio 2
library IEEE;
use IEEE.std_logic_1164.all;

entity exercicio_2 is
  port (
    a : in bit;
    b : in bit;
    c : in bit;
    x : out bit
  );
end exercicio_2;
  
architecture arquitetura_2 of exercicio_2 is
begin
  x <= (a and b) or (a and c);
end arquitetura_2;
