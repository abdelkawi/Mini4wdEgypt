package com.mini4wd.egypt.domain

import com.mini4wd.egypt.data.model.Round

interface RoundRepo {
  fun addRound(round: Round)
  fun setRoundResult(round: Round)
}