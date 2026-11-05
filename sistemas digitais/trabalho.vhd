-- Arquivo componente_sistema.vhd
-- Sistema Flip Flop JK
library IEEE;
use IEEE.std_logic_1164.all;

entity componente_sistema is
port (
    j, k : in bit;
    q, q1 : out bit
);
end componente_sistema;

architecture arquitetura_sistema of componente_sistema is
    component componente_nand
        port (a, b : in bit; x : out bit);
    end component;
    
	signal s1, s2: bit;

begin
	nand1: componente_nand port map (a => j, b => q1, x => s1);
    nand2: componente_nand port map (a => k, b => q, x => s2);
    nand3: componente_nand port map (a => s1, b => q1, x => q);
    nand4: componente_nand port map (a => q, b => s2, x => q1);
end arquitetura_sistema;


-------------------------


-- Simple NAND gate design
library IEEE;
use IEEE.std_logic_1164.all;

entity nand_gate is
port(
  a: in std_logic;
  b: in std_logic;
  x: out std_logic);
end nand_gate;

architecture rtl of nand_gate is
begin
  process(a, b) is
  begin
    x <= a nand b;
  end process;
end rtl;
