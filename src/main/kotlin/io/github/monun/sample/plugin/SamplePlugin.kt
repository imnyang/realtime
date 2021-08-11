package io.github.monun.sample.plugin

import dev.jorel.commandapi.CommandAPI
import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.CommandAPIConfig
import dev.jorel.commandapi.CommandPermission
import dev.jorel.commandapi.executors.CommandExecutor
import org.bukkit.plugin.java.JavaPlugin

/**
 * @author Monun
 */
class SamplePlugin : JavaPlugin() {
    override fun onEnable() {
        CommandAPI.onLoad(CommandAPIConfig().verboseOutput(true))
        CommandAPI.onEnable(this)

        CommandAPICommand("test").apply {
//            withPermission(CommandPermission.NONE)
            setRequirements {
                Thread.currentThread().stackTrace.forEach { println(it) }
                true
            }
            executes(CommandExecutor { sender, args ->
                println("EXECUTED")
            })

        }.register()
    }
}