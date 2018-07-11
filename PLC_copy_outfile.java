/*
Python Language Converter(PLC)
Converts Source Code from language A to B
*/

// Configure logging module
logging.basicConfig(filename="PLC_log.log", level=logging.DEBUG);

// Create variables for user input
user_input = {
  "file_path": None,
  "to_language": None,
  "output_file_name": None,
}


public void plc() {
  /*Main PLC application*/
  
  // Create user input string template
  input_msg = "{} or 'q' to abort: ";
    
    // Create input messages
    input_file_path_msg = input_msg.format("Path to Program File");
    input_language_msg = input_msg.format("To Language");
    input_file_name_msg = input_msg.format("Output File Path");
    
    // Create variable to store function result
    lang_from = None;
    
    //
    // Get User Input
    //
    
    validate_methods = [
      (FilePath.validate_file_path, "file_path", input_file_path_msg),
      (Language.validate, "lang_to", input_language_msg),
      (FilePath.validate_file_name, "outfile_path", input_file_name_msg),
    ]
    
    // Validate user input
    for (Array.data_type func,: input_strinvalidate_methods) {
      
      // Get input from user
      user_input_val, error = get_user_input(func, var_name, input_str);
      
      user_input_val = str(user_input_val);
      
      // If error encountered, print error and exit
      while (error) {
        
        // Parse the error
        Error.parse(error, user_input=True);
        
        // Get input from user
        user_input_val, error = get_user_input(func, var_name, user_input_val);
        
        // Store latest value of var
        user_input[var_name] = user_input_val;
        
        // If var_name is file_path recognize language of infile
        if (var_name == "file_path") {
          lang_from = Language.recognize(user_input_val);
          
          // else if var_name is language,
          // store lower string(no capitals) of var_name
          else if (var_name == "lang_to") {
            user_input[var_name] = user_input_val.lower();
          }
        }
        //
        // Start Conversion
        //
        
        // Make local variables for keys in user_input dict
        file_path = user_input['file_path']
        lang_to = user_input['lang_to']
        outfile_path = user_input['outfile_path']
        
        System.out.println(lang_from, "->", lang_to);
        
        // Create code processor instance
        code_processor = CodeProcessor(file_path, lang_from, lang_to, outfile_path);
        
        // Run convert method of code processor
        code_processor.convert();
        
        // Write converted file to disk
        error = code_processor.write_file_to_disk();
        
        // Check if error occurred
        if (error) {
          Error.parse(error, user_input=False);
          
          return 0;
          
          
          public void get_user_input(method func, String var_name, String input_str) {
            /*Gets input from user and runs standard protocols*/
            
            // Get user input
            var = str(input(input_str));
            
            // Log debug message
            logging.debug("{} {}".format(var_name, var));
              
              // Check if user requests abort
              if (var == "q") {
                Error.parse("User Abort", user_input=True);
                
                // Define function parameters
                function_params = tuple([var]);
                
                // Check for special cases
                if (var_name == "outfile_path") {
                  
                  // Define function parameters
                  function_params = (var, user_input['lang_to']);
                  
                  // Run validation
                  return var, func(*function_params);
                  
                  
                  class Plc_Copy_Outfile {
                    public static void main(String[] args) {
                      /*Function run on file open*/
                      
                      // Run plc function
                      plc();
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
