#' @title die
#' @description create an object 'die' with sides and probability
#' @param a list of sides and list of probability
#' @return 'die' object
#' @export
#' @examples
#' # default
#' die1 <- die()
#'
#' # another die
#' die2 <- die(c('a', 'b', 'c', 'd', 'e', 'f'), c(0.1, 0.1, 0.1, 0.1, 0.1, 0.5))

die = function(sides = c(1:6), prob = rep(1/6, 6)) {

  check_sides(sides)
  check_prob(prob)

  res = list(sides = sides, prob = prob)

  class(res) = 'die'
  return(res)
}

#' @title check_sides
#' @description check if given sides have the length of 6
#' @param a list of six values
#' @return boolean
check_sides = function(sides) {
  if (length(sides) != 6) {
    stop("\n'sides' must be a vector of length 6")
  }
  return(TRUE)
}

#' @title check_prob
#' @description check if given probability adds up to 1 and is valid
#' @param a list of six probability values
#' @return boolean
check_prob = function(prob) {
  if (!is.numeric(prob)) {
    stop("\n'prob' must be a numeric vector")
  }
  if (any(prob < 0) | any(prob > 1)) {
    stop("\n'prob' values must be between 0 and 1")
  }
  if (sum(prob) != 1) {
    stop("\nelements in 'prob' must add up to 1")
  }
  return(TRUE)
}

#' @export
print.die <- function(x) {
  cat('object "die"\n\n')
  cd <- data.frame(
    side = x$sides, prob = x$prob
  )
  print(cd)
  invisible(x)
}
