import unittest, sys, io, random
from compare_files import compare_files
from contextlib import redirect_stdout
from unittest.mock import patch
from pig import *

class TestConditions(unittest.TestCase):

    def test_print_scores(self):
        with io.StringIO() as buf, redirect_stdout(buf):
            self.assertIsNone(print_scores("Ziggy", 18, "Elmer", 23))    
            self.assertEqual("\n--- SCORES\tZiggy: 18\tElmer: 23 ---\n", buf.getvalue())

    def test_check_for_winner(self):
        self.assertIsNotNone(check_for_winner("Elmer", 30))
        with io.StringIO() as buf, redirect_stdout(buf):
            self.assertTrue(check_for_winner("Ziggy",50))
            self.assertEqual("THE WINNER IS: Ziggy!!!!!\n", buf.getvalue())
        with io.StringIO() as buf, redirect_stdout(buf):
            self.assertTrue(check_for_winner("Ziggy",51))
            self.assertEqual("THE WINNER IS: Ziggy!!!!!\n", buf.getvalue())
        with io.StringIO() as buf, redirect_stdout(buf):
            self.assertFalse(check_for_winner("Elmer", 49))
            self.assertEqual("", buf.getvalue())

    def test_roll_again(self):
        with patch('builtins.input', side_effect=['Y']):
            self.assertIsNotNone(roll_again("Ziggy"))
        with io.StringIO() as buf, redirect_stdout(buf):
            with patch('builtins.input', side_effect=['y']):
                self.assertTrue(roll_again("Ziggy"))  
                self.assertEquals('', buf.getvalue())
        with io.StringIO() as buf, redirect_stdout(buf):
            with patch('builtins.input', side_effect=['Y']):
                self.assertTrue(roll_again("Ziggy"))  
                self.assertEquals('', buf.getvalue())
        with io.StringIO() as buf, redirect_stdout(buf):
            with patch('builtins.input', side_effect=['n']):
                self.assertFalse(roll_again("Elmer"))  
                self.assertEquals('', buf.getvalue())
        with io.StringIO() as buf, redirect_stdout(buf):
            with patch('builtins.input', side_effect=['N']):
                self.assertFalse(roll_again("Elmer"))  
                self.assertEquals('', buf.getvalue())
        with io.StringIO() as buf, redirect_stdout(buf):
            with patch('builtins.input', side_effect=['Never', 'N']):
                self.assertFalse(roll_again("Elmer"))  
                self.assertEquals("""I don't understand: \"Never\". """ + \
                    'Please enter either "Y" or "N".\n', buf.getvalue())
        #testing prompts
        sys.stdin = open('roll_again_in.txt')
        with io.StringIO() as buf, redirect_stdout(buf):
            self.assertTrue(roll_again("Johnny"))
            out_text1 = "Roll again, Johnny? (Y/N) " + \
                       """I don't understand: \"Never\". """ + \
                       'Please enter either "Y" or "N".\n' + \
                       "Roll again, Johnny? (Y/N) " + \
                       """I don't understand: \"Sure Thing\". """ + \
                       'Please enter either "Y" or "N".\n' + \
                       "Roll again, Johnny? (Y/N) " + \
                       """I don't understand: \"Si\". """ + \
                       'Please enter either "Y" or "N".\n' + \
                       "Roll again, Johnny? (Y/N) "
            self.assertEqual(out_text1, buf.getvalue())
        sys.stdin = sys.__stdin__

    def test_play_turn(self):
        random.seed(87) #[2, 6, 2, 5, 1, 3, 3, 6, 5, 6, 3, 6, 1]

        with io.StringIO() as buf, redirect_stdout(buf):      
            with patch('builtins.input', side_effect = ['y','y', 'n']): 
                self.assertEquals(10, play_turn("Henry")) 
                self.assertEquals("---------- Henry's turn ----------\n" + \
                    "\t<<< Henry rolls a 2 >>>\n" + \
                    "\tPoints: 2\n\t<<< Henry rolls a 6 >>>\n\tPoints: 8\n" + \
                    "\t<<< Henry rolls a 2 >>>\n\tPoints: 10\n", buf.getvalue())
        with io.StringIO() as buf, redirect_stdout(buf):      
            with patch('builtins.input', side_effect = ['y','y']): 
                self.assertEquals(0, play_turn("Johnny")) 
                self.assertEquals("---------- Johnny's turn ----------\n" + \
                    "\t<<< Johnny rolls a 5 >>>\n" + \
                    "\tPoints: 5\n\t<<< Johnny rolls a 1 >>>\n" + \
                    "\t!!! PIG! No points earned, sorry Johnny !!!\n", buf.getvalue())
        with io.StringIO() as buf, redirect_stdout(buf):      
            with patch('builtins.input', side_effect = ['n']): 
                self.assertEquals(3, play_turn("Henry")) 
                self.assertEquals("---------- Henry's turn ----------\n" + \
                    "\t<<< Henry rolls a 3 >>>\n\tPoints: 3\n", buf.getvalue())
        # testing prompts
        sys.stdin = open('play_turn_in.txt')
        with io.StringIO() as buf, redirect_stdout(buf):
            play_turn("Johnny")
            out_text = "---------- Johnny's turn ----------\n" + \
                       "\t<<< Johnny rolls a 3 >>>\n" + \
                       "\tPoints: 3\n" + \
                       "Roll again, Johnny? (Y/N) " + \
                       "\t<<< Johnny rolls a 6 >>>\n" + \
                       "\tPoints: 9\n" + \
                       "Roll again, Johnny? (Y/N) " + \
                       "\t<<< Johnny rolls a 5 >>>\n" + \
                       "\tPoints: 14\n" + \
                       "Roll again, Johnny? (Y/N) " + \
                       "\t<<< Johnny rolls a 6 >>>\n" + \
                       "\tPoints: 20\n" + \
                       "Roll again, Johnny? (Y/N) " + \
                       "\t<<< Johnny rolls a 3 >>>\n" + \
                       "\tPoints: 23\n" + \
                       "Roll again, Johnny? (Y/N) " + \
                       "\t<<< Johnny rolls a 6 >>>\n" + \
                       "\tPoints: 29\n" + \
                       "Roll again, Johnny? (Y/N) " + \
                       "\t<<< Johnny rolls a 1 >>>\n" + \
                       "\t!!! PIG! No points earned, sorry Johnny !!!\n" + \
                       "(enter to continue)"
            self.assertEqual(out_text, buf.getvalue())
        sys.stdin = sys.__stdin__
            
    def test_main(self):
        save_in = sys.stdin
        save_out = sys.stdout
        infile = open('intest.txt')
        outfile = open('main_out.txt', 'w')
        sys.stdin = infile
        sys.stdout = outfile
        main() 
        sys.stdin = save_in
        sys.stdout = save_out
        infile.close()
        outfile.close()

        self.assertTrue(compare_files('main_out_correct.txt','main_out.txt'))
            
test = unittest.defaultTestLoader.loadTestsFromTestCase(TestConditions)
results = unittest.TextTestRunner().run(test)
sys.stdout = sys.__stdout__
sys.stdin = sys.__stdin__
print('Correctness score = ', str((results.testsRun - len(results.errors) - len(results.failures)) / results.testsRun * 100) + '%')
