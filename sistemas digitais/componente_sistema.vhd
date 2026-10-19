-- Arquivo componente_sistema.vhd
-- Sistema com portas AND e NOT e OR
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
    component componente_not
        port (x : in bit; y : out bit);
    end component;
signal s1, s2, s4 : bit;


begin
or1: componente_or port map (d => in1, e => in2, f => s1);
and2: componente_and port map (a => in3, b => in4, c => s2);
not2: componente_not port map (x => s2, y => s4);
or2: componente_or port map (d => s1, e => s4, f => out1);
