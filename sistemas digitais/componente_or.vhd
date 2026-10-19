-- Arquivo componente_or.vhd
-- Modelo da porta OR
library IEEE;
use IEEE.std_logic_1164.all;

entity componente_or is
  port (
    d : in bit;
    e : in bit;
    f : out bit
  );
end componente_or;
  
architecture arquitetura_or of componente_or is
begin
  f <= d and e;
end arquitetura_or;
