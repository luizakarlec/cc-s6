-- Arquivo componente_sistema.vhd
-- Sistema com portas OR, AND e NOT
library IEEE;
use IEEE.std_logic_1164.all;

entity componente_sistema is
port (
    in1, in2, in3, in4 : in bit;
    out1 : out bit
);
end componente_sistema;

architecture arquitetura_sistema of componente_sistema is
    component componente_or
        port (d, e : in bit; f : out bit);
    end component;
    component componente_and
        port (a, b : in bit; c : out bit);
    end component;
signal s1, s2 : bit;


begin
or1: componente_or port map (d => in1, e => in2, f => s1);
or2: componente_or port map (d => in3, e => in4, f => s2);
and1: componente_and port map (a => s1, b => s2, c => out1);
