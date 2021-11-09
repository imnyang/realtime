package io.github.monun.sample.plugin

import kotlinx.coroutines.sync.Mutex
import org.bukkit.plugin.java.JavaPlugin

/**
 * @author Monun
 */
class SamplePlugin : JavaPlugin() {
    override fun onEnable() {
        Mutex().tryLock()
    }
}