-- Arquivo componente_and.vhd
-- Modelo da porta AND
library IEEE;
use IEEE.std_logic_1164.all;

entity componente_and is
  port (
    a : in bit;
    b : in bit;
    c : out bit
  );
end componente_and;
  
architecture arquitetura_and of componente_and is
begin
  c <= a and b;
end arquitetura_and;
