with Ada.Integer_Text_IO;
use Ada.Integer_Text_IO;
with Ada.Float_Text_IO; use Ada.Float_Text_IO;
with Ada.Text_IO; use Ada.Text_IO;

procedure A is
--   type My_Float is digits 5;
   S: String(1 .. 50) := (others => ' ');
   Last: Integer;
   P: Float;
   X: Float := 0.0;
   R: Float;
begin
   Get_Line(S, Last);
   Get(P);
   for i in 1..Last loop
      if (S(I) = '1') then
         X := X + 1.0;
      end if;
      if (S(I) = '?') then
         X := X + ((P)*1.0);
      end if;
   end loop;
   R := X/Float(Last);
   Put(R,Aft=>5,Exp=>0);
end A;
